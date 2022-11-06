import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
    }

    void save(Resume r) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                if (Objects.equals(storage[i].uuid, r.uuid)) {
                    System.out.println("Ошибка. Элелемент с таким uuid уже существует");
                    break;
                }
            }
            if(storage[i] == null){
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
            return  null;
        }
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return 0;
    }
}
