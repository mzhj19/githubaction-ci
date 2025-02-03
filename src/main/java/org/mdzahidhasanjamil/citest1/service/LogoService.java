package org.mdzahidhasanjamil.citest1.service;

import org.mdzahidhasanjamil.citest1.model.Logo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LogoService {
    Logo saveLogo(MultipartFile file) throws IOException;

    byte[] getLogo(Long id);
}
