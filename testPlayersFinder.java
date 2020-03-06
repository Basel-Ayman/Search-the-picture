package eg.edu.alexu.csd.datastructure.iceHockey.cs18;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class testPlayersFinder {
    @Test
    public void test(){
        PlayersFinder a = new PlayersFinder();
        //Test_1
        String[] photo1 = { "33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
        Point[] centerPoints1 = {new Point (4,5),new Point (13,9),new Point (14,2)};
        Assert.assertArrayEquals(centerPoints1, a.findPlayers(photo1, 3, 16));
        //Test_2
        String[] photo2 = { "44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
        Point[] centerPoints2 = {new Point (3,8),new Point (4,16),new Point (5,4),new Point (16,3),new Point (16,17),new Point (17,9)};
        Assert.assertArrayEquals(centerPoints2, a.findPlayers(photo2, 4, 16));
        //Test_3
        String[] photo3 = {"8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8EO", "LUQ888A8TH8OIH8", "888QJ88R8SG88TY", "88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8", "8MX88D88888T8K8", "8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8", "8PK8H8T8888TQR8" };
        Point[] centerPoints3 = {new Point (1,17),new Point (3,3),new Point (3,10),new Point (3,25),new Point (5,21),new Point (8,17),
                new Point (9,2),new Point (10,9),new Point (12,23),new Point (17,16),new Point (18,3),new Point (18,11),new Point (18,28),
                new Point (22,20),new Point (23,26),new Point (24,15),new Point (27,2),new Point (28,26),new Point (29,16)};
        Assert.assertArrayEquals(centerPoints3, a.findPlayers(photo3, 8, 9));
        //Test_4
        String[] photo4 = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
        Point[] centerPoints4 = {new Point (5,5),new Point (5,5)};
        Assert.assertArrayEquals(centerPoints4, a.findPlayers(photo4, 1, 3));
        //Test_5
        String[] photo5 = {"11111", "11111", "11111"};
        Point[] centerPoints5 = {};
        Assert.assertArrayEquals(centerPoints5, a.findPlayers(photo5, 3, 16));
        //Test_6
        String[] photo6 = {"22222", "22222", "22222"};
        Point[] centerPoints6 = {};
        Assert.assertArrayEquals(centerPoints6, a.findPlayers(photo6, 2, 80));
        //Test_7
        String[] photo7 = {};
        Point[] centerPoints7 = {};
        try {
            Assert.assertArrayEquals(centerPoints7, a.findPlayers(photo7, 1, 8));
        }catch (Exception x){
            System.out.println(x.getMessage());
        }
        //Test_8
        String[] photo8 = { "33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
        Point[] centerPoints8 = {new Point (4,5),new Point (13,9),new Point (14,2)};
        try {
            Assert.assertArrayEquals(centerPoints8, a.findPlayers(photo8, 3, -16));
        }catch (Exception x){
            System.out.println(x.getMessage());
        }

    }

}
