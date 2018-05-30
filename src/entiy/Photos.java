package entiy;

import javax.servlet.annotation.WebServlet;

public class Photos {
    private int id;       //图片编号
    private String authorname;//作者名称
    private String type;       //类型
    private String picturepath;//图片所在地

    public void setId (int id) {
        this.id = id;
    }

    public void setAuthorname (String authorname) {
        this.authorname = authorname;
    }

    public void setType (String type) {
        this.type = type;
    }

    public void setPicturepath (String picturepath) {
        this.picturepath = picturepath;
    }

    public int getId ( ) {
        return id;
    }

    public String getAuthorname ( ) {
        return authorname;
    }

    public String getType ( ) {
        return type;
    }

    public String getPicturepath ( ) {
        return picturepath;
    }
}
