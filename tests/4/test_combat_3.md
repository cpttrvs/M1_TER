#interaction de combat
###TER CogLogo - Joseph Stich

##contenu implémenté
- les agents cherchent à attaquer si leur énergie le permet, sinon ils s'enfuient pour régénerer
- la capacité de combattre est calculée de la façon suivante : force + connaissance du terrain * la valeur du terrain
- gagner l'intéraction fait perdre un point de vie au destinataire si le destinataire ne pare pas
- le système de parade : si l'initiateur gagne l'interaction (devrait toucher le destinataire), le destinataire peut parer. Si il pare, il gagne alors un bonus temporaire de force jusqu'à sa prochaine intéraction

##remarque sur le contenu implémenté
J'ai décidé de faire le système de parade lors de la réussite de l'intéraction. En effet l'agent qui attaque réussit, donc qu'il a l'ascendant, peut voir son coup se faire parer. Ainsi, le destinataire a l'avantage de la riposte (bonus de force). Cette riposte ne concerne que la prochaine intéraction (avec l'initiateur initial, ou un autre. Par exemple, C pare l'attaque de A, mais C se fait attaquer par B au même moment; l'avantage de la parade est consommé lors de l'intéraction B vers C)

Bug : Cependant, les agents gardent parfois leur bonus "temporaire", je n'ai pas encore correctement isolé d'où venait l'erreur

##proposition pour la prochaine fois
- résoudre le problème du bonus permanent
- lorsqu'un agent se fait parer son attaque, il apprend et réduit donc la chance de parade de son adversaire (pour les intéractions entre ces deux agents)
- ajouter un type d'arme qui dépend vraiment de l'environnement