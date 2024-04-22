package com.tdm.prototipo_margens.services;

import com.tdm.prototipo_margens.main.DTOs.AuthenticationDTO;

public interface AuthenticateService {
    String login(AuthenticationDTO usuario);

}
