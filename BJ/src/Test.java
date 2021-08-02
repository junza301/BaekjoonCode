import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test {

	public static void main(String[] args){
		ArrayList<Integer>[] RPG = new ArrayList[5];
        for(int i = 1; i < 5; i++) {
        	RPG[i] = new ArrayList<Integer>();
        }
        RPG[1].add(3);
        System.out.println(RPG[1].get(0));
	}

}
