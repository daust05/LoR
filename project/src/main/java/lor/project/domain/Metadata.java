package lor.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter @Setter
public class Metadata {
    static String developerCode;

    public static String getDeveloperCode(){
        return developerCode;
    }

    public static void setDeveloperCode(String code){
        developerCode = code;
    }

}