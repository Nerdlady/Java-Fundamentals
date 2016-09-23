package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true){
			String line = reader.readLine();
			if (line.equals("HARVEST")){
				break;
			}

			Field[] fields = RichSoilLand.class.getDeclaredFields();

			switch (line){
				case "private":
					for (Field field : fields) {
						if (Modifier.isPrivate(field.getModifiers())){
							String mod = Modifier.toString(field.getModifiers());
							System.out.printf("%s %s %s%n",mod,field.getType().getSimpleName(),field.getName());
						}
					}
					break;
				case "protected":
					for (Field field : fields) {
						if (Modifier.isProtected(field.getModifiers())){
							String mod = Modifier.toString(field.getModifiers());
							System.out.printf("%s %s %s%n",mod,field.getType().getSimpleName(),field.getName());
						}
					}
					break;
				case "public":
					for (Field field : fields) {
						if (Modifier.isPublic(field.getModifiers())){
							String mod = Modifier.toString(field.getModifiers());
							System.out.printf("%s %s %s%n",mod,field.getType().getSimpleName(),field.getName());
						}
					}
					break;
				case "all":
					for (Field field : fields) {
						String mod = Modifier.toString(field.getModifiers());
						System.out.printf("%s %s %s%n",mod,field.getType().getSimpleName(),field.getName());
					}

			}
		}
	}
}
