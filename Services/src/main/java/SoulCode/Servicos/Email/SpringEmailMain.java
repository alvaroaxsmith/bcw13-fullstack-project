package SoulCode.Servicos.Email;


import SoulCode.Servicos.Email.envio.Mailer;
import SoulCode.Servicos.Email.envio.Mensagem;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringEmailMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringEmailMain.class.getPackage().getName());

        Mailer mailer = applicationContext.getBean(Mailer.class);
        mailer.enviar(new Mensagem("Alexandre Teste <isisferreira1996@gmail.com>",
                Arrays.asList("Testes AlgaWorks <isisferreira1996@gmail.com>")
                , "Aula Spring E-mail", "Olá! \n\n O envio de e-mail deu certo!"));

        applicationContext.close();

        System.out.println("Fim!");
    }


}
