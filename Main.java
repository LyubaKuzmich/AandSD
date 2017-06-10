package pack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiP on 09.06.2017.
 */
public class Main {

    public static void main(String[] args)
    {
        int n = 6; // количество шестеренок
        int[][] related = {{1,3},{2},{3},{4},{1},{2}}; //ребра, где i, j означает, что i-тая шестеренка связана с j-той
        List<List<Integer>> list = new ArrayList<>();
        connectRelative(n,list,related);
        rotate(n, list);
    }

    public static void connectRelative(int n, List<List<Integer>> list, int[][] t)
    {
        for (int i = 0; i < n; i++)
        {
            list.add(i, new ArrayList<>());

            for (int j = 0; j < t[i].length; j++)
            {
                list.get(i).add(t[i][j]);
                System.out.println((i + 1) + " шестеренка соединена с " + (t[i][j] + 1) + " шестеренкой.");
            }
        }
    }

    public static void rotate(int n, List<List<Integer>> list)
    {
        List<Integer> rotateList = new ArrayList<>();
        rotateList.add(0, 1);
        //true - поворот, по часовой стрелке.
        //false - поворот, против часовой стрелке.

        for (int i = 1; i < n; i++) {
            for (int index : list.get(i))
            {
                if (rotateList.get(i - 1) == 1)
                {
                    rotateList.add(0);
                }
                else
                {
                    rotateList.add(1);
                }
            }
        }

        System.out.println();
        int pos = 0;
        for (int color : rotateList)
        {
            System.out.println((pos+1) + " шестеренка вращается " +
                    (color == 1 ? "по часовой " : "против часовой "));
            pos++;
        }
        boolean isFirstRotating = true;
        for (int i = 0; i < list.get(0).size();i++)
        {
            if (rotateList.get(list.get(0).get(i)) == 1)
            {
                isFirstRotating = false;
            }
        }

        for(int i=1; i<n; i++)
        {
            for(int index : list.get(i))
            {
                for (int j = 0; j < list.get(i).size() ; j++)
                    if(list.get(i).get(j) == 0)
                    {
                        if(rotateList.get(i) == 1)
                        {
                            isFirstRotating = false;
                        }
                    }
            }
        }
        System.out.print("\nПервая шестеренка - ");
        if (isFirstRotating)
            System.out.print("вращается");
        else System.out.print("не вращается.");

    }

}
