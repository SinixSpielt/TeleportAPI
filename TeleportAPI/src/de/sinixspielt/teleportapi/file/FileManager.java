package de.sinixspielt.teleportapi.file;

/*
Class created on 02.03.2019 by SinixSpielt
 * */

public class FileManager {

	private MessagesFile messagesFile;
	
	public FileManager() {
		this.messagesFile = new MessagesFile();
	}
	
	public MessagesFile getMessagesFile() {
		return messagesFile;
	}
}