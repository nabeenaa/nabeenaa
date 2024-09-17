

## Project Overview
This project implements a dynamic array in Java, extending a base class `DynamicArray`. This assignment showcases understanding of dynamic arrays by implementing key operations such as adding and removing items, resizing the array, and calculating amortised complexity. The dynamic array adjusts its capacity as needed and keeps track of performance metrics related to the addition of items.

## Components

### 1. **MyUoKDynamicArray.java**

This class extends the `DynamicArray` class and provides implementations for the following operations:

- **Array Management**: Dynamically adjusts the size of the internal array.
- **Item Addition**: Adds items to the array and handles resizing based on a given factor.
- **Item Removal**: Removes items from specified positions and adjusts array size if necessary.
- **Performance Metrics**: Calculates amortised complexity for the `add` operation.
- **Testing**: Includes basic tests to validate the implementation of various methods.

### 2. **DynamicArray.java**
This is a reference class provided for the assignment. It is not modified and should not be submitted. It contains the base implementation and documentation for the dynamic array functionality.

## Methods

### **`isFullQ1()`**
Checks if the dynamic array is full by comparing the `nextFreeSlot` with the `capacity`.
```java
boolean isFullQ1()
```
- **Returns**: `true` if the array is full, `false` otherwise.

### **`addItemQ2(int item, double x)`**
Adds an item to the dynamic array. If the array is full, it resizes the array based on a factor `x`.
```java
void addItemQ2(int item, double x)
```
- **Parameters**:
  - `item`: The item to be added.
  - `x`: The factor by which the array capacity will be multiplied if resizing is needed.

### **`calcAddAmCompQ3()`**
Calculates the amortized complexity of the `add` operation.
```java
double calcAddAmCompQ3()
```
- **Returns**: The average number of operations per `add` operation.

### **`removeItemAtQ4(int position)`**
Removes an item from the specified position in the array and adjusts the size if necessary.
```java
void removeItemAtQ4(int position)
```
- **Parameters**:
  - `position`: The index of the item to be removed.

### **Testing Methods**

#### **`basicTestQ1a()`**
Tests the functionality of `isFullQ1()`.
```java
void basicTestQ1a()
```

#### **`basicTestQ1b()`**
Performs a test by adding items until the array is full, validating `isFullQ1()`.
```java
void basicTestQ1b()
```

#### **`basicTestQ2()`**
Tests the `addItemQ2` method by adding items with a specified resizing factor.
```java
void basicTestQ2()
```

#### **`basicTestQ3()`**
Calculates and prints the amortized complexity of the `add` operation.
```java
void basicTestQ3()
```

#### **`basicTestQ4a()`**
Tests the `removeItemAtQ4()` method by removing an item at a random position.
```java
void basicTestQ4a()
```

#### **`basicTestQ4b()`**
Tests the `removeItemAtQ4()` method by attempting to remove an item at the current `nextFreeSlot`.
```java
void basicTestQ4b()
```

## Attributes

- **`hiddenArray`**: The underlying array that holds the actual data for the dynamic array.
- **`nextFreeSlot`**: An integer index indicating the next available slot in the array.
- **`capacity`**: The current capacity of the `hiddenArray`.
- **`opCountForAdds`**: Tracks the number of single operations performed on the array during `add` operations.
- **`numItemsAdded`**: Counts the total number of items added to the array.

## How to Run
To run the `MyUoKDynamicArray` class:
1. Compile the Java files:
    ```sh
    javac MyUoKDynamicArray.java DynamicArray.java
    ```
2. Run the `MyUoKDynamicArray` class:
    ```sh
    java MyUoKDynamicArray
    ```

