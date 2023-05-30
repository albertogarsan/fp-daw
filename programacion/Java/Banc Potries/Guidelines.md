### Banc Popular de Potries ###

PART 1 

Tindrem varios tipus de comptes: corrents, d'estalvi, inversió, criptocompte. 
Tot heretaran de la classe abstracta Compte. 

Classe abstracta Compte:
- ID
- Titular
- Qdiners
- Qualificació (1/100)

Classe CompteCorrent:
- Data d'obertura
- Bonificació

Classe CompteEstalvis:
- Data d'obertura
- Interès (1/100)

Classe CompteInversió:
- Tipus (Euro, Dolar, Peniques, Dirhams) enum

Classe CompteCripto:
- Hash (String 5 caracters alphanumèrics)
- URL bàsica

Interficie
· Interficies del compters (tots): 
- ingresar, retirar, transferir

Operacions
1 - donar d'alta
2 - de baixa
3 - modificar dades d'un compte
4 - operar amb el compte
4.1 - ingressar diners
4.2 - retirar diners
4.3 - fer transferències


-------------------------------------
PART 2 
// Treballarem amb les persones, on guardarem treballadors i clients del banc. Tant treballadors com clients heretaran de la classe abstracta persona.

// Respecte als treballadors o clients, també els podrem donar d'alta, baixa, modificar les dades, associar comptes,crear compters.