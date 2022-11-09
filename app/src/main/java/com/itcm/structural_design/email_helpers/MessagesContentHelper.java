package com.itcm.structural_design.email_helpers;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.BasicActivity;

public class MessagesContentHelper {

    private String subject,increaseCountContent,restorePasswordContent;

    public MessagesContentHelper(String email){
        subject = BasicActivity.context.getString(R.string.email_subject);
        increaseCountContent = "<h2>" + "בוצע התחברות על ידי משתמש " + email + "</h2>";
    }

    public MessagesContentHelper(String name,String password){
        subject = BasicActivity.context.getString(R.string.email_subject);
        restorePasswordContent = "<h2>" + "שלום " + name + "</h2>" +
                "<h3>" + "בקשתך לשיחזור הסיסמה התקבלה, סיסמתך היא: " + password + "</h3>" +
                "<h4>" +
                "המלצתנו לשנות כל 3 חודשים את הסיסמה." +
                "</h4>" +
                "<h4>" +
                "עומדים לרשותך תמיד , צוות Build-it" +
                "</h4>";
    }

    public String getSubject(){ return subject; }
    public String getContent() { return increaseCountContent; }
    public String getRestorePasswordContent() { return restorePasswordContent; }
}
