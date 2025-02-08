package org.mdzahidhasanjamil.citest1.service;

import java.io.IOException;
import org.mdzahidhasanjamil.citest1.model.Logo;
import org.springframework.web.multipart.MultipartFile;

public interface LogoService {
Logo saveLogo(MultipartFile file) throws IOException;

byte[] getLogo(Long id);
}
