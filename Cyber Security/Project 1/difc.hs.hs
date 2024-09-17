type Identifier = String

type EContext = [(Identifier,Value)]

data Label = Public
           | Secret
  deriving (Eq, Show)

join :: Label -> Label -> Label
join Public Public = Public
join _ Secret = Secret
join Secret _ = Secret

data BaseValue = BoolVal Bool
               | NumVal Int
               | StringVal String
               | LamVal Identifier Expr
               deriving (Show)

               

data Value = Lab BaseValue Label
  deriving (Show)


data Expr = Var String
          | NExp Int
          | BExp Bool
          | Plus Expr Expr
          | Conj Expr Expr
          | Ifelse Expr Expr Expr
          | Lam Identifier Expr
          | App Expr Expr
          deriving Show 

eval :: EContext -> Expr -> Value
eval ec (Var n) = snd $ head (filter (\(x, _) -> x == n) ec)
eval ec (BExp n) = Lab (BoolVal n) Public
eval ec (NExp n) = Lab (NumVal n) Public
eval ec (Plus e1 e2) =
  let (Lab (NumVal v1) l1) = eval ec e1
      (Lab (NumVal v2) l2) = eval ec e2
  in Lab (NumVal (v1 + v2)) (join l1 l2)

eval ec (Conj e1 e2) = let (Lab (BoolVal v1) l1) = (eval ec e1) in
                         let (Lab (BoolVal v2) l2) = (eval ec e2) in
                           Lab (BoolVal (v1 && v2)) (join l1 l2)
eval ec (Ifelse e e1 e2) = let (Lab (BoolVal v) l) = (eval ec e) in
                             if v == True
                             then
                               let (Lab v1 l1) = eval ec e1 in
                                 Lab v1 (join l l1)
                             else
                               let (Lab v2 l2) = eval ec e2 in
                                 Lab v2 (join l l2)
eval ec (Lam e e1) = Lab (LamVal e e1) Public
eval ec (App e1 e2) = let (Lab (LamVal x e) l) = eval ec e1 in
                        let (Lab v1 l1) = eval ec e2 in
                          let (Lab v2 l2) = eval ((x, Lab v1 l1):ec) e in
                            Lab v2 (join l l2)

