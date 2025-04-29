
public class Chat {

    Salon[] channels;
    int indexLibreChannels;

    public Chat() {
        this.channels = new Salon[10];
        this.indexLibreChannels = 0;
    }

    public boolean estPresent(Utilisateur user) {
        for (int i = 0; i < this.channels.length; i++) {
            if (this.channels[i] == null) {
                return false;
            }
            if (this.channels[i].estPresent(user)) {
                return true;
            }
        }
        return false;
    }

    public int countMessages() {
        int res = 0;
        for (int i = 0; i < this.channels.length; i++) {
            if (this.channels[i] == null) {
                return -1;
            }
            res += this.channels[i].tabMessage.length;
        }

        return res;
    }

    public Utilisateur bavard() {
        if (this.channels.length == 0) {
            return null;
        }

        Utilisateur CCP = this.channels[0].bavard();
        Salon CCPChannel = this.channels[0];

        for (int i = 1; i < this.channels.length; i++) {
            if (this.channels[i] == null) {
                continue;
            }

            if(CCPChannel.countUserMessages(CCP) < this.channels[i].countUserMessages(this.channels[i].bavard())) {
                CCP = this.channels[i].bavard();
                CCPChannel = this.channels[i];
            }
        
        }

        return CCP;
    }
}
