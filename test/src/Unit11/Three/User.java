package Unit11.Three;

public class User
{

    private String name;
    private String password;

    public User(String name)
    {
        this.name = name;
        this.password = "";
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public String setName(String name)
    {
        return this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public String setPassword(String password)
    {
        return this.password = password;
    }

    public String getUserInfo()
    {
        return name + "," + password;
    }
}