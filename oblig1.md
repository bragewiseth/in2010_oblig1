# Oblig 1

## Oppgave 2 

#### a)
For å implementere "Teque" bruker jeg to sirkulere arrays `f` og `b` som representerer hver sin halvdel av køen. Hver array har en tilhørende `front` og en `back` peker. De døpes `f_front`, `f_back`, `b_front` og `b_back`. `f` for første halvdel `b` for andre halvdel. `b_front` fortsetter køen der `f_back` slapp. Det vil si at hvis `b_front` tilsvarer indeks $5$ så vil `f_back` tilsvare indeks $4$. `f` og `b` har hver sin referanse til mengder elementer i seg selv. Det brukes til å balansere de to.<br><br>

> ### Algoritme: get
>
> **input:** indeks $i$  
> **output:** elementet på indeks $i$

~~~ java
prosedyre get(i) 

        if i < f_size then
               
            j 🢦 (f_front - 1) - i
            if j < 0 then return f[ |f| + j ]
            else return f[j]
    
        else 

            j 🢦 (b_front - 1) - (i - f_size)
            if j < 0 then return b[ |b| + j ]
            else return b[j]
~~~

> ### Algoritme: Midt i kø
>
> **input:** element $x$  
> *plasserer element $x$ midt i køen*

~~~ java
prosedyre push_middle(x) 
    
        if f_size < b_size

            f[f_back] 🢦 b[ b_front - 1 ]
            b[b_front-1] 🢦 x
            f_size++
            f_back--
            if f_back < 0 then f_back 🢦 (|f| - 1)
    
        else 
           
            b[b_front] 🢦 x
            b_size++
            b_front++
            if b_front > (|b| - 1) then b_front 🢦 0
~~~

> ### Algoritme: Bakerst i kø
>
> **input:** indeks $i$  
> *plasserer element $x$ bakerst i køen*

~~~ java
prosedyre push_back(x) 
    
        b[b_back] 🢦 x
        b_back--
        b_size++
        if b_back < 0 then b_back 🢦 (|b| - 1)
        balanser()
~~~ 

> ### Algoritme: Først i kø
>
> **input:** element $x$
> *plasserer element $x$ fremst i køen*

~~~ java
prosedyre push_front(x) 
    
        f[f_front] 🢦 x
        f_front++
        f_size++
        if f_front > (|f| - 1) then f_front 🢦 0
        balanser()
~~~

> ### Algoritme: Balanser kø
>  
> *justerer størrelen på fremste og bakerste del av køen*

~~~ java
prosedyre balanser()
    
        d 🢦 f_size - b_size
        if d > 1

            f_back++
            b[b_front] 🢦 f[f_back]
            f[f_back] 🢦 null
            b_front++
            if b_front > (|b| - 1) then b_front 🢦 0
            f_size--
            b_size++
        
        if d < -1
        
            b_front--
            f[f_back] 🢦 b[b_front]
            b[b_front] 🢦 null
            f_back--
            if f_back < 0  f_back 🢦 (|f| - 1)  
            b_size--
            f_size++
~~~

#### c)

Alle operasjonene har kjøretidskompleksitet på konstant tid $\mathcal{O}(1)$. Det vil si uvhengig av $N$. Selve løkken der input blir lest inn vil ha kompleksitet $\mathcal{O}(n)$ men denne kjøres bare en gang.

#### d)

Hvis $N$ er begrenset til f.eks $10^6$ blir kompleksiteten $\mathcal{O}(n)\rightarrow \mathcal{O}(10^6)\rightarrow \mathcal{O}(1)$, som er konstanttid.  
I mitt tilfelle har ikke det så mye å si siden alle operasjonene er i konstanttid uansett.
<br><br>         

## Oppgave 3

Bruker det faktum at hvert element kun forekommer en gang.
så setter elementet på indeks med samme verdi som elementet. hvis det allerede er et
element på plassen oppdateres barn og foreldre til den noden. alle inputfiler har maks input med to siffer så kan lage en array med plass til $100$ elementer. En node har feltene `parent` og `element` som begge er heltall.

>   ### Algoritme: sett inn
>   
>   **input:** en array $A$ og em node $z$  
>   Plasserer en node i arrayet, hvis det er en node der fra før skal noden med informasjon om `parent` bli plassert der

~~~ java
prosedyre settInn(A,z)
    
    if A[z.element] = null then
         
        tre[z.element] 🢦 z
        return
    
    if A[z.element] ≠ null ∧ z.parrent = null then 
        return
   
    A[z.element] = z;
~~~

>   ### Algoritme: print vei
>   
>   **input:** en node $c$  
>   **output:** printer veien til stdout

~~~ java
prosdyre printVei(c)
    print c.element
    if A[c.parrent] = null then return
    printvei(A[c.parent])
~~~

## Oppgave 4

#### a)

planen er å halvere listen mange ganger. Starter med øvre halvdel for hver iterasjon:  
$\{0,1,2,3,4,5,6,7,8,9,10\}$ tar ut $5$ ⇝ $\{6,7,8,9,10\}$ tar ut $8$ ⇝ $\{9,10\}$  tar ut $10$ og så $9$  
$\{6,7\}$ tar ut $7$ og så $6$  
$\{0,1,2,3,4\}$ tar ut $2$ osv...  

Vi skal gjennomføre binærsøk på en måte

>   ### Algoritme: binerdeling
>   **input:** en *$ordnet$* array $A$ og heltall `bakerste` og `fremste`  
>   **output:** printer den den omstokkede listen til stdout

~~~ java 
prosedyre dele(A, bakerste, fremste)
   
    if (fremste - bakerste) < 2 then
        print A[fremste]
        print A[bakerste]
        return
   
    print A[(fremste + bakerste) / 2]
    nyBak = ((bakerste + fremste) / 2) + 1
    dele(A, nyBak, fremste)
    nyBak = bakerste
    fremste = ((bakerste + fremste) / 2) - 1
    dele(A, nyBak, fremste)
~~~

#### b)

samme ting bare med heaps.