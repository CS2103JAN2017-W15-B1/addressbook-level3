package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;

import java.nio.file.Path;

/*
 * Abstraction of the Storage objects that
 * Logic class has to work with.
 */
public abstract class Storage {
    public Path path;
    
    /**
     * Signals that some errors have occured while trying to convert and read/write data
     * between the application and the storage object.
     */
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }
    
    /**
     * Signals that the given file path does not fulfill the storage filepath constraints.
     */
    public static class InvalidStorageFilePathException extends IllegalValueException {
        public InvalidStorageFilePathException(String message) {
            super(message);
        }
    }
    
    /*
     * @return String representation of the Path to the storage object.
     */
    public abstract String getPath();
    
    /*
     * Save all data to this Storage object.
     * 
     * @throws StorageOperationException if there were errors reading and/or converting data from file.
     */
    public abstract void save(AddressBook addressBook) throws StorageOperationException;
    
    /*
     * Loads data from this storage object.
     * 
     * @throws StorageOperationException if there were errors reading and/or converting data from file.
     */
    public abstract AddressBook load() throws StorageOperationException;
}
