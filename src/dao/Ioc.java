package dao;

public class Ioc {
    public static Object Inject(String className){
        switch (className){
            case "LoginDao": return LoginDao.getInstance();
        }
    return null;
    }

}
