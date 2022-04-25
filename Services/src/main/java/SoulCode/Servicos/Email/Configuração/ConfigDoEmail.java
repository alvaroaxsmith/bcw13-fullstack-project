package SoulCode.Servicos.Email.Configuração;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:env/mail.properties")
public class ConfigDoEmail {

    @Autowired
    private Environment envio;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(envio.getProperty("mail.smtp.host"));
        javaMailSender.setPort(envio.getProperty("mail.smtp.port", Integer.class));
        javaMailSender.setUsername(envio.getProperty("mail.smtp.username"));
        javaMailSender.setPassword(envio.getProperty("mail.smtp.password"));

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.connectiontimeout", 10000);

        javaMailSender.setJavaMailProperties(properties);

        return javaMailSender;
    }
}
