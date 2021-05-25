package ru.zhenyaak;

import java.io.FileNotFoundException;
import ru.zhenyaak.service.Menu;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Menu.startMenu();
		Menu.showMenu();
	}
}