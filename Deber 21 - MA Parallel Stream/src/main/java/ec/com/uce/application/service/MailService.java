package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Mail;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
@Transactional
@ApplicationScoped
public class MailService {

    @MedirTiempo
    public void guardarMail(Mail mail){
        
        String nombrehiloMailS = Thread.currentThread().getName();

            System.out.println("nombre del hilo MailS  " + nombrehiloMailS);
        System.out.println("ID: "+ Thread.currentThread().threadId());
        mail.persist();
    }






}
