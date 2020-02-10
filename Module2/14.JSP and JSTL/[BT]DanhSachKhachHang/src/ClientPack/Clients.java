package ClientPack;


import java.util.ArrayList;

public class Clients
{
    public static ArrayList<String[]> getClients()
    {
        String client1[]=new String[]{
                "Mai Van Hoan",
                "1983-08-20",
                "Ha Noi",
                "<img src=\"https://picsum.photos/100\">",
        };
        String client2[]=new String[]{
                "Nguyen Van Nam",
                "1983-08-21",
                "Bac Giang",
                "<img src=\"https://picsum.photos/100\">",
        };

        String client3[]=new String[]{
                "Nguyen Thai Hoa",
                "1983-08-22",
                "Tay Nguyen",
                "<img src=\"https://picsum.photos/100\">",
        };

        String client4[]=new String[]{
                "Tran Dang Khoa",
                "1983-08-23",
                "Vung Tau",
                "<img src=\"https://picsum.photos/100\">",
        };

        String client5[]=new String[]{
                "Nguyen Dinh Thi",
                "1983-08-24",
                "Bac Giang",
                "<img src=\"https://picsum.photos/100\">",
        };
        ArrayList<String[]> listClients=new ArrayList<>();
        listClients.add(client1);
        listClients.add(client2);
        listClients.add(client3);
        listClients.add(client4);
        listClients.add(client5);

        return listClients;
    }
}
