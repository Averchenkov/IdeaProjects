package semestr3.test.Test1;

import javax.swing.*;

public class BrowserOpener
{
    private String os;
    private Runtime runtime;
    private boolean defender_1, defender_2, defender_3;
    public BrowserOpener()
    {
        os = System.getProperty("os.name").toLowerCase();
        runtime = Runtime.getRuntime();
    }
    public void openLinkInBrowser(String url)
    {
        defender_1 = (url.contains("www.") && url.length() != 0);  // проверка на соблюдение адреса
        defender_2 = (url.contains("https://") && url.length() != 0); //
        defender_3 = (url.contains("http://") && url.length() != 0); //
        if(defender_1 || defender_2 || defender_3)
        {
            try
            {
                if(isWindows())
                {
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
                }
                else if(isMac())
                {
                    runtime.exec("open " + url);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else // если адрес не верно указан, выдает ошибку
            JOptionPane.showMessageDialog(null, "WRONG URL, ENTER ANOTHER");
    }
    private boolean isWindows() // проверка системы windows или macOs
    {
        return os.contains("win");
    }

    private boolean isMac()
    {
        return os.contains("mac");
    }
}