package com.tyss.aopcustomannotation.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceMessage {
    private String message;
    private String updateMessage;
    private String failed;
}
