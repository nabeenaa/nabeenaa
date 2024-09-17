
# Information Flow Control (IFC) Runtime Monitor

## Overview

This project implements a **runtime monitor** for **Information Flow Control (IFC)** within a functional interpreter. It ensures proper confidentiality levels (`Public` and `Secret`) for data by dynamically controlling how information flows during expression evaluation. The interpreter evaluates arithmetic, boolean operations, lambda functions, and conditionals while enforcing these security rules.

### Information Flow Control (IFC)
- **Public**: Non-sensitive data.
- **Secret**: Sensitive data that must not leak to lower-confidentiality contexts.
  
Labels propagate using a `join` operation, ensuring that any operation involving `Secret` data results in a `Secret` output.

## Key Components

- **Label**: Tracks data confidentiality (`Public` or `Secret`).
- **BaseValue**: Evaluates basic types—`Bool`, `Int`, `String`, and `Lam` (Lambda).
- **Value**: A base value paired with a label, using `Lab BaseValue Label`.
- **Expr**: Represents expressions like variables, numbers, booleans, addition, conjunctions, conditionals, and lambda applications.

### `join` Function
Combines two labels:
```haskell
join :: Label -> Label -> Label
join Public Public = Public
join _ Secret = Secret
```

### `eval` Function
Evaluates expressions and propagates confidentiality labels:
```haskell
eval :: EContext -> Expr -> Value
```
Key operations include:
- **Addition (`Plus`)**: Adds two numbers, with label propagation.
- **Conditionals (`Ifelse`)**: Executes branches based on conditions, propagating the strictest label.
- **Function Application (`App`)**: Applies a lambda to an argument while maintaining label integrity.

## Example Test Cases

1. **Basic Arithmetic**:
   ```haskell
   eval [] (Plus (NExp 1) (NExp 2)) 
   -- Result: Lab (NumVal 3) Public
   ```

2. **Secret Data Flow**:
   ```haskell
   let env = [("x", Lab (NumVal 42) Secret)]
   eval env (Plus (Var "x") (NExp 1))
   -- Result: Lab (NumVal 43) Secret
   ```

3. **Lambda Function**:
   ```haskell
   let env = [("f", Lab (Lam "x" (Plus (Var "x") (NExp 2))) Public)]
   eval env (App (Var "f") (NExp 5))
   -- Result: Lab (NumVal 7) Public
   ```

## Conclusion

This project implements a secure information flow mechanism within an interpreter, enforcing that secret data does not leak to public contexts through dynamic label propagation.
