package io.github.bhaskarpramanik.automation.screenplay.abilities;

import io.github.bhaskarpramanik.automation.screenplay.capabilities.Capability;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memorize implements Capability {
  private final Map<String, Memory> memoryMap;

  {
    this.memoryMap = new ConcurrentHashMap<>();
  }

  public record Memory(Object value, Class<?> valueType) {}

  public interface MemoryItem {
    void stores(Object value) throws IllegalArgumentException;
  }

  public MemoryItem remembersThat(String key) {
    return value -> {
      if (key == null || value == null)
        throw new IllegalArgumentException("Memory key or value can not be null.");
      this.memoryMap.put(key, new Memory(value, value.getClass()));
    };
  }

  public void remembersAll(Map<String, Object> committedObjects) {
    committedObjects.forEach((key, value) -> this.remembersThat(key).stores(value));
  }

  public Object recallsValueOf(String key) {
    Memory value = this.memoryMap.get(key);
    return value.valueType.cast(value.value);
  }

  public void forgetsValueOf(String key) {
    this.memoryMap.remove(key);
  }

  public void forgetAll() {
    this.memoryMap.clear();
  }

  public int countsMemorizedObjects() {
    return this.memoryMap.size();
  }
}
