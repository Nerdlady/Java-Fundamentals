package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Method[] methods = BlackBoxInt.class.getMethods();
        Class<BlackBoxInt> blackBoxIntClass = (Class<BlackBoxInt>) Class.forName("pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt");
        Constructor<BlackBoxInt> blackBoxCtor = blackBoxIntClass.getDeclaredConstructor();
        blackBoxCtor.setAccessible(true);
        BlackBoxInt boxedIntInstance = blackBoxCtor.newInstance();

        while (true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }

            String[] info = line.split("_");
            int num = Integer.parseInt(info[1]);
            Method method = blackBoxIntClass.getDeclaredMethod(info[0],int.class);
            method.setAccessible(true);
            method.invoke(boxedIntInstance,num);
            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.getInt(boxedIntInstance));

        }
	}
}
