public class Logger {
    private StringBuilder logger;

    public Logger() {
        this.logger = new StringBuilder("");
    }

    public void startMatch(String p1, String p2) {
        logger.append( "Incepe lupta: " + p1 + " vs " + p2 + "\n");
    }

    public void addAttack(int type, String nume) {
        if( type == 0 ) {
            logger.append(nume + " atac cu normal/special.\n");
        }
        else if( type == 1 ) {
            logger.append(nume + " atac cu abilitate 1.\n");
        }
        else {
            logger.append(nume + " atac cu abilitate 2.\n");
        }
    }

    public void showHP(Pokemon pokemon) {
        logger.append(pokemon.nume + " HP: " + pokemon.HP + "\n");
    }

    public void showCooldown(int no, Pokemon p) {
        if( no == 1 )
            logger.append(p.nume + " Cooldown 1 " + p.cooldown1 + " until ready.\n");
        if( no == 2 )
            logger.append(p.nume + " Cooldown 2 " + p.cooldown2 + " until ready.\n");
    }

    public void win(Pokemon p) {
        if( p == null )
            logger.append("Draw\n");
        else
            logger.append(p.nume + " a castigat.\n");
    }

    public String getLog() {
        return logger.toString();
    }
}
