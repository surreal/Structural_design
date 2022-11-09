package com.itcm.structural_design.email_helpers;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.AuthenticationActivity;
import com.itcm.structural_design.activities.BasicActivity;
import com.itcm.structural_design.activities.ContactActivity;
import com.itcm.structural_design.helpers.Internet;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;
import com.itcm.structural_design.interfaces.OnAsyncPostUserDetailsListener;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import static com.itcm.structural_design.activities.BasicActivity.EMAIL_SENT_ERROR;
import static com.itcm.structural_design.activities.BasicActivity.PORT_CLOSED_ERROR;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_SEND_PASSWORD_EMAIL;
import static com.itcm.structural_design.activities.BasicActivity.SUCCESSFUL_EMAIL_SENT;
import static com.itcm.structural_design.activities.BasicActivity.activityActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;

public class SendEmailAsyncTask extends AsyncTask<String, String, String> {

    private File file;
    private final Message message;
    private final Multipart multipart;
    private MimeBodyPart attachPart;
    //  private FileHelper fileHelper;
    private Session session;

    public SendEmailAsyncTask() {
        multipart = new MimeMultipart();
//    fileHelper = new FileHelper();
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.hostinger.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("team@bitengos.com", "******");
            }
        });
//        session.setDebug(true);
        message = new MimeMessage(session);
        Internet.isInternetConnected();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "שולח דוא\"ל...", Toast.LENGTH_LONG).show();
    }

    // values[0] : email; values[1] : content; values[2] : filePath;
    @Override
    protected String doInBackground(String... values) {
        Socket socket;
        if (!Internet.isInternetConnected()) {
            return EMAIL_SENT_ERROR;
        } else {
            try {
                socket = new Socket("smtp.gmail.com", 465);
                socket.close();
                Log.d("checkPortOpen", "port is open");
            } catch (SocketException e) {
                e.printStackTrace();
                Log.d("checkPortOpen", "port is CLOSE EXCEPTION == " + e);
                return "יש חסימה ברשת שלך, דוא\"ל לא נשלח! התחבר לרשת אחרת.";
            } catch (IOException e) {
                Log.d("checkPortOpen", "port is CLOSE EXCEPTION == " + e);
                e.printStackTrace();
                return PORT_CLOSED_ERROR;
            }
            try {
                attachPart = new MimeBodyPart();
                attachPart.setContent(values[1], "text/html; charset=utf-8");
                multipart.addBodyPart(attachPart);
                if (values.length > 2 && !values[2].equals("")) {
                    file = new File(values[2]);
                    Log.d("checkSendEmail", "file.exists() == " + file.exists());
                    attachPart = new MimeBodyPart();
                    attachPart.attachFile(file);
                    attachPart.setFileName(new String(file.getName().getBytes(), StandardCharsets.ISO_8859_1));
                    multipart.addBodyPart(attachPart);
                }
            } catch (IOException | MessagingException e) {
                e.printStackTrace();
            }

            try {
                message.setFrom(new InternetAddress("team@bitengos.com"));
                Log.d("checkSendEmail", "SendEmailAsyncTask{} doInBackground() -> clientEmail == " + values[0]);
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(values[0]));
                message.setSubject(context.getString(R.string.email_subject));
                message.setContent(multipart, "text/html; charset=utf-8");
                //message.setFileName(fileName);
                Transport.send(message);
                return SUCCESSFUL_EMAIL_SENT;
            } catch (MessagingException e) {
                Log.d("checkSendEmail", "catch e == " + e.toString());
                e.printStackTrace();
                return EMAIL_SENT_ERROR;
            }
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("checkSendEmail", "onPostExecute() -> result == " + result);
        if (activityActiveId.equals(AuthenticationActivity.AUTHENTICATION_ACTIVITY))
            ((OnAsyncPostUserDetailsListener) context).onAsyncPostUserDetailsResult(null, QUERY_TYPE_SEND_PASSWORD_EMAIL, result);
        else if (activityActiveId.equals(ContactActivity.CONTACT_ACTIVITY))
            ((OnAsyncPostListener) context).onAsyncPostResult(result);
        switch (result) {
            case SUCCESSFUL_EMAIL_SENT:
                Toast.makeText(context, context.getString(R.string.email_sent), Toast.LENGTH_LONG).show();
                break;
            case BasicActivity.PORT_CLOSED_ERROR:
                Toast.makeText(context, "יש חסימה ברשת שלך, דוא\"ל לא נשלח! התחבר לרשת אחרת.", Toast.LENGTH_LONG).show();
                break;
            case EMAIL_SENT_ERROR:
                Toast.makeText(context, "דוא\"ל לא נשלח - אין חיבור אינטרנט", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
