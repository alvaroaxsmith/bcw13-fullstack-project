package SoulCode.Servicos.Email;


import SoulCode.Servicos.Email.envio.PacoteEnvio;
import SoulCode.Servicos.Email.envio.Mensagem;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringEmailMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringEmailMain.class.getPackage().getName());

        PacoteEnvio mailer = applicationContext.getBean(PacoteEnvio.class);
        mailer.enviar(new Mensagem(" Isis <isisferreira1996@gmail.com>",
                Arrays.asList(" <isisferreira1996@gmail.com>"),"Testando .....",
                 "Olá! \n\n O envio de e-mail deu certo!"));

        applicationContext.close();

        System.out.println("Encerrado!");
    }


}
