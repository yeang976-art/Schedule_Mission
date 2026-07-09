package com.example._60705.userCRUD.layer;

import com.example._60705.userCRUD.dto.*;
import com.example._60705.userCRUD.entity.User;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    // 회원가입
    @Transactional
    public SignUpResponseDTO signUp(SignUpRequestDTO request) {
        User u = new User(request.getName(), request.getEmail(), request.getPassword());
        User saveUser = repository.save(u);

        return new SignUpResponseDTO(saveUser.getId(), saveUser.getName(), saveUser.getEmail(), saveUser.getCreateAt());
    }

    // 로그인
    @Transactional(readOnly = true)
    public UserSession login(LoginRequestDTO request) {
        User u = repository.findByEmail(request.getEmail()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 일치하지 않습니다."));

        if (!u.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        return new UserSession(u.getId(), u.getName(), u.getEmail());
    }

    @Transactional(readOnly = true)
    public GetResponseDTO readOne(Long id) {
        User u = checkData(id);

        return new GetResponseDTO(u.getId(), u.getName(), u.getEmail(), u.getCreateAt(), u.getUpdatedAt());
    }

    @Transactional
    public List<GetResponseDTO> readAll() {
        List<User> list = repository.findAll();

        return list.stream()
                .map(a -> new GetResponseDTO(a.getId(), a.getName(), a.getEmail(), a.getCreateAt(), a.getUpdatedAt()))
                .toList();
    }

    // 이름 변경
    @Transactional
    public UpdateResponseDTO edit(Long id, UpdateRequestDTO request) {
        User u = checkData(id);
        u.setName(request.getName());
        u.updateDate();

        return new UpdateResponseDTO(u.getId(), u.getName(), u.getEmail(), u.getUpdatedAt());
    }

    @Transactional
    public void remove(Long id) {
        User u = checkData(id);

        repository.delete(u);
    }

    private User checkData(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "존재하지 않는 일정"));
    }
}
