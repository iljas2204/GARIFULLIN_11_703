package ru.itis.project.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.project.forms.SettingsUserForm;
import ru.itis.project.forms.SignInForm;
import ru.itis.project.forms.SignUpForm;
import ru.itis.project.models.Auth;
import ru.itis.project.models.User;
import ru.itis.project.repositories.AuthRepository;
import ru.itis.project.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UsersServiceImpl implements UsersService {

    private PasswordEncoder encoder;

    private UsersRepository usersRepository;
    private AuthRepository authRepository;

    public UsersServiceImpl(UsersRepository usersRepository, AuthRepository authRepository) {
        this.usersRepository = usersRepository;
        this.authRepository = authRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public UsersServiceImpl(AuthRepository authRepository, UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.authRepository = authRepository;
        this.encoder = passwordEncoder;
    }

    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .login(form.getLogin())
                .hashPassword(encoder.encode(form.getPassword()))
                .build();

        usersRepository.save(user);
    }

    @Override
    public void edit(SettingsUserForm form) {
        User user = User.builder()
                .id(form.getId())
                .login(form.getLogin())
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .git(form.getGit())
                .build();

        usersRepository.update(user, form.getId());
    }

    @Override
    public String signIn(SignInForm form) {

        Optional<User> userOptional = usersRepository.findOneByLogin(form.getLogin());
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            if (!encoder.matches(form.getPassword(), user.getHashPassword())) {
                throw new IllegalArgumentException("Wrong password or email");
            }
        } else throw new IllegalArgumentException("Wrong password or email");


        if (user != null && encoder.matches(form.getPassword(), user.getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();

            Auth auth = Auth.builder()
                    .user(user)
                    .cookieValue(cookieValue)
                    .build();

            authRepository.save(auth);

            return cookieValue;
        }
        return null;
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }
    @Override
    public Optional<User> Login (String cookieValue){
        if(usersRepository.findOneByCookie(cookieValue).isPresent()){
            return usersRepository.findOneByCookie(cookieValue);
        }
        return null;
    }

    @Override
    public Optional<User> find(Long id) {
        return usersRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }
}
