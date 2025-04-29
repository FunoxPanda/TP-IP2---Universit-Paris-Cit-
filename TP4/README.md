# Travail Pratique 4 : IntFList

Programme de structure de données.
Ce *repository* contient 1 classe :
- [IntFList](./IntFList.java)

Le sujet est disponible [ici](./sujet.pdf).

# Documentation

La classe `IntFList` implémente une **liste chaînée immuable** d'entiers, où chaque élément de la liste est représenté par une instance de `IntFList`.

### Attributs :
- `public static final IntFList NULL_INTLIST` : Liste vide (valeur de référence).
- `private final boolean empty` : Indicateur de liste vide.
- `private final int first` : Premier élément de la liste.
- `private final IntFList rest` : Reste de la liste (prochain élément).

### Constructeurs :
- **`IntFList()`** : Constructeur de la liste vide, initialise `empty = true`, `first = 0`, et `rest = null`.
- **`IntFList(int e, IntFList ll)`** : Constructeur avec un entier `e` et une liste `ll` pour créer une nouvelle liste où `e` est le premier élément et `ll` est le reste.

### Méthodes principales :

- **`boolean isNull()`** : Vérifie si la liste est vide (`empty`).
- **`int head()`** : Retourne le premier élément de la liste.
- **`IntFList tail()`** : Retourne le reste de la liste (la queue).
- **`IntFList cons(int e)`** : Ajoute un élément `e` en tête de la liste.
- **`int length()`** : Retourne la longueur de la liste.
- **`int sum()`** : Calcule la somme des éléments de la liste.
- **`boolean ordered()`** : Vérifie si la liste est ordonnée (les éléments sont dans l'ordre décroissant).
- **`boolean contains(int e)`** : Vérifie si un élément `e` est présent dans la liste.
- **`IntFList removeOnlyOneTime(int e)`** : Supprime la première occurrence de l'élément `e` de la liste.
- **`IntFList remove_last(int e)`** : Supprime la dernière occurrence de l'élément `e` de la liste.
- **`String toString()`** : Retourne une représentation sous forme de chaîne de caractères de la liste.

# Droits d'auteurs

**Sujet de TP :**
2025 (c) Université Paris Cité - Tous droits réservés
Cours par [Giulio Manzonetto](https://www.irif.fr/~gmanzone/)

**Proposition de correction :** Ewen Rodrigues de Oliveira (moi-même)
