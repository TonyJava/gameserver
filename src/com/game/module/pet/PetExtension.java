package com.game.module.pet;

import com.game.params.Int2Param;
import com.game.params.IntParam;
import com.game.params.pet.MutateVO;
import com.server.anotation.Command;
import com.server.anotation.Extension;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lucky on 2017/9/13.
 */
@Extension
public class PetExtension {
    @Autowired
    private PetService petService;

    @Command(7001)
    public Object getPetBag(int playerId, Object param) {
        return petService.getPets(playerId);
    }

    @Command(7002)
    public Object gainPet(int playerId, IntParam param) {
        return petService.gainPet(playerId, param.param);
    }

    @Command(7004)
    public Object compound(int playerId, Int2Param param) {
        return petService.compound(playerId, param.param1, param.param2);
    }

    @Command(7005)
    public Object decompose(int playerId, IntParam param) {
        return petService.decompose(playerId, param.param);
    }

    @Command(7006)
    public Object mutate(int playerId, MutateVO param) {
        return petService.mutate(playerId, param.mutateID, param.consumeID, param.newSkillID);
    }

    @Command(7007)
    public Object improveQuality(int playerId, IntParam param) {
        return petService.improveQuality(playerId, param.param);
    }

    @Command(7008)
    public Object toFight(int playerId, IntParam param) {
        return petService.toFight(playerId, param.param);
    }
}
