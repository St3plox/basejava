import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) storage[i] = null;
            else break;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                if (Objects.equals(storage[i].uuid, r.uuid)) {
                    System.out.println("Ошибка. Элелемент с таким uuid уже существует");
                    break;
                }
            }
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        if (storage[0] == null) return null;
        else {
            int i = 0;
            while (storage[i] != null) {
                if (Objects.equals(storage[i].uuid, uuid)) return storage[i];
                i++;
            }
            return null;
        }
    }

    void delete(String uuid) {
        if (storage[0] == null) System.out.println("В массиве нет ни одной записи");
        else {
            int i = 0;
            while (storage[i] != null) {
                if (Objects.equals(storage[i].uuid, uuid)) {
                    storage[i] = null;
                    if (storage[i + 1] != null) {
                        for (int k = i; storage[k + 1] != null; k++) {
                            storage[k] = storage[k + 1];
                        }
                    }
                    break;
                }
                i++;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int storage_size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) storage_size++;
            else break;
        }
        Resume[] _storage = new Resume[storage_size];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) _storage[i] = storage[i];
            else break;
        }

        return _storage;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) size++;
            else break;
        }
        return size;
    }

}
