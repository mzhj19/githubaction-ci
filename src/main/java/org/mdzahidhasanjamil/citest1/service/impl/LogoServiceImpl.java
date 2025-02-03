package org.mdzahidhasanjamil.citest1.service.impl;

import org.mdzahidhasanjamil.citest1.model.Logo;
import org.mdzahidhasanjamil.citest1.repository.LogoRepository;
import org.mdzahidhasanjamil.citest1.service.LogoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class LogoServiceImpl implements LogoService {
    private final LogoRepository logoRepository;

    public LogoServiceImpl(LogoRepository logoRepository) {
        this.logoRepository = logoRepository;
    }

    public Logo saveLogo(MultipartFile file) throws IOException {
        Logo logo = new Logo();
        logo.setName(file.getOriginalFilename());
        logo.setImage(file.getBytes());
        return logoRepository.save(logo);
    }

    public byte[] getLogo(Long id) {
        Optional<Logo> logo = logoRepository.findById(id);
        return logo.map(Logo::getImage).orElse(null);
    }
}
