package ai.freya;

import l2p.gameserver.ai.CtrlEvent;
import l2p.gameserver.ai.Mystic;
import l2p.gameserver.model.Player;
import l2p.gameserver.model.instances.NpcInstance;
import bosses.ValakasManager;

public class ValakasMinion extends Mystic {

    public ValakasMinion(NpcInstance actor) {
        super(actor);
        actor.startImmobilized();
    }

    @Override
    protected void onEvtSpawn() {
        super.onEvtSpawn();
        for (Player p : ValakasManager.getZone().getInsidePlayers()) {
            notifyEvent(CtrlEvent.EVT_AGGRESSION, p, 5000);
        }
    }
}