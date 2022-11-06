import java.util.Arrays;
import java.util.Objects;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        boolean unique = true;
        if (size == 0) {
            storage[0] = r;
            size++;
        } else {
            for (int i = 0; i <= size; i++) {
                if (i <= size - 1) {
                    if (Objects.equals(storage[i].uuid, r.uuid)) break;
                } else if (i == size) {
                    storage[i] = r;
                    size++;
                    break;
                }
            }
        }
    }


    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (Objects.equals(storage[i].uuid, uuid)) return storage[i];
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = Arrays.copyOf(storage, size);
        return resumes;
    }

    int size() {
        return size;
    }

}
