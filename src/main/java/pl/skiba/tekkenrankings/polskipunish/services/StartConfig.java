package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.skiba.tekkenrankings.polskipunish.models.AppUser;
import pl.skiba.tekkenrankings.polskipunish.repo.AppUserRepo;

@Configuration
public class StartConfig {

    private AppUserRepo appUserRepo;

    public StartConfig(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;

        AppUser admin = new AppUser();
        admin.setUsername("jan");
        admin.setPassword(passwordEncoder.encode("nowak"));
        admin.setRole("ROLE_ADMIN");
        admin.setEnabled(true);
        appUserRepo.save(admin);

        AppUser appUser = new AppUser();
        appUser.setUsername("marek");
        appUser.setPassword(passwordEncoder.encode("marek"));
        appUser.setRole("ROLE_USER");
        appUser.setEnabled(true);
        appUserRepo.save(appUser);
    }




}