package com.emanuel.vet.email.mapper;

import com.emanuel.vet.email.domains.Email;
import com.emanuel.vet.email.dtos.EmailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    @Mapping(source = "from", target = "fromEmail")
    @Mapping(source = "to", target = "toEmail")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "text", target = "text")

    Email EmailDTOToEmail(EmailDTO emailDTO);
}
