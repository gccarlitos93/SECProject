package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.master.Master;

public interface Mediator {
  void startingDummyScreen(Dummy.ToDummy presenter);
  void startingMainScreen(Main.ToMain presenter);
  void startingMasterScreen(Master.ToMaster presenter);
  void resumingMasterScreen(Master.DetailToMaster presenter);
}
