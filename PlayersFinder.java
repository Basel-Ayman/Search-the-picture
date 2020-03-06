package eg.edu.alexu.csd.datastructure.iceHockey.cs18;

import java.awt.*;

public class PlayersFinder implements IPlayersFinder {
    public static int rowMin, rowMax, colMin, colMax, counter;
    public static void checkPlayer(int row, int col, char[][] photo, int team) {
        if (row<rowMin)rowMin=row;
        if (row>rowMax)rowMax=row;
        if (col<colMin)colMin=col;
        if (col>colMax)colMax=col;
        counter++;
        if (col<photo[row].length-1 && photo[row][col+1]==team+'0') {
            photo[row][col+1] = 'b';
            checkPlayer(row,col+1,photo,team);
        }
        if ( col>0 && photo[row][col-1]==team+'0') {
            photo[row][col-1] = 'b';
            checkPlayer(row,col-1,photo,team);
        }
        if (row<photo.length-1 && photo[row+1][col]==team+'0') {
            photo[row+1][col] = 'b';
            checkPlayer(row+1,col,photo,team);
        }
        if (row>0 && photo[row-1][col]==team+'0') {
            photo[row-1][col] = 'b';
            checkPlayer(row-1,col,photo,team);
        }
    }

    public static void sortPoints (Point[] points) {
        Point temp ;
        if (points.length!=0) {
            for (int i = 0;i<points.length-1;i++) {
                for (int j=i+1;j<points.length;j++) {
                    if (points[i].x>points[j].x) {
                        temp = points[i];
                        points[i] = points[j];
                        points[j] = temp ;
                    }else if (points[i].x==points[j].x) {
                        if (points[i].y>points[j].y) {
                            temp = points[i];
                            points[i] = points[j];
                            points[j] = temp ;
                        }
                    }
                }
            }
        }
    }

    @Override
    public java.awt.Point[] findPlayers(String[] photo, int team, int threshold) {
        Point [] centerPoints = new Point [2500];
        int temp = 0;
        if (photo.length!=0 && team>= 0 && team <=9 && threshold>0) {
            char [][] arr = new char [photo.length][photo[0].length()];
            for (int i = 0;i<photo.length;i++) {
                arr[i]=photo[i].toCharArray();
            }
            int player=(threshold+3)/4;
            for (int row=0;row<arr.length;row++) {
                for (int col=0;col<arr[row].length;col++) {
                    rowMin=50;
                    rowMax=0;
                    colMin=50;
                    colMax=0;
                    counter=0;
                    if (arr[row][col]==team+'0') {
                        arr[row][col] = 'b';
                        checkPlayer (row,col,arr,team);
                    }
                    if (counter >= player) {
                        centerPoints[temp] = new Point (colMin+colMax+1,rowMin+rowMax+1);
                        temp++;
                    }
                }
            }
        }else throw new RuntimeException ("This image is empty or there is wrong information.");
        Point [] points = new Point [temp];
        System.arraycopy(centerPoints, 0, points, 0, temp);
        sortPoints(points);
        return points ;
    }
}
