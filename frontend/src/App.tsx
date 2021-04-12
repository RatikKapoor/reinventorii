import { Redirect, Route } from "react-router-dom";
import {
  IonApp,
  IonIcon,
  IonLabel,
  IonRouterOutlet,
  IonTabBar,
  IonTabButton,
  IonTabs,
} from "@ionic/react";
import { IonReactRouter } from "@ionic/react-router";
import { ellipse, square, triangle } from "ionicons/icons";
import Chairs from "./pages/Chairs";
import Desks from "./pages/Desks";
import OrderItem from "./pages/OrderItem";
import { GiOfficeChair, GiDeskLamp, GiDesk } from "react-icons/gi";
import { FcFilingCabinet } from "react-icons/fc";

/* Core CSS required for Ionic components to work properly */
import "@ionic/react/css/core.css";

/* Basic CSS for apps built with Ionic */
import "@ionic/react/css/normalize.css";
import "@ionic/react/css/structure.css";
import "@ionic/react/css/typography.css";

/* Optional CSS utils that can be commented out */
import "@ionic/react/css/padding.css";
import "@ionic/react/css/float-elements.css";
import "@ionic/react/css/text-alignment.css";
import "@ionic/react/css/text-transformation.css";
import "@ionic/react/css/flex-utils.css";
import "@ionic/react/css/display.css";

/* Theme variables */
import "./theme/variables.css";
import Lamps from "./pages/Lamps";
import Filings from "./pages/Filing";

/**
 * main react application container
 * @returns main react app to be rendered
 */
const App: React.FC = () => (
  <IonApp>
    <IonReactRouter>
      <IonTabs>
        <IonRouterOutlet>
          <Route exact path="/chairs">
            <Chairs />
          </Route>
          <Route exact path="/desks">
            <Desks />
          </Route>
          <Route exact path="/lamps">
            <Lamps />
          </Route>
          <Route exact path="/filings">
            <Filings />
          </Route>
          <Route path="/order">
            <OrderItem />
          </Route>
          <Route exact path="/">
            <Redirect to="/chairs" />
          </Route>
        </IonRouterOutlet>
        <IonTabBar slot="bottom">
          <IonTabButton tab="chairs" href="/chairs">
            <GiOfficeChair size="30" />
            <IonLabel>Chairs</IonLabel>
          </IonTabButton>
          <IonTabButton tab="desks" href="/desks">
            <GiDesk size="30" />
            <IonLabel>Desks</IonLabel>
          </IonTabButton>
          <IonTabButton tab="lamps" href="/lamps">
            <GiDeskLamp size="30" />
            <IonLabel>Lamps</IonLabel>
          </IonTabButton>
          <IonTabButton tab="filings" href="/filings">
            <FcFilingCabinet size="30" />
            <IonLabel>Filings</IonLabel>
          </IonTabButton>
          <IonTabButton tab="order" href="/order">
            <IonIcon icon={square} />
            <IonLabel>Order Item</IonLabel>
          </IonTabButton>
        </IonTabBar>
      </IonTabs>
    </IonReactRouter>
  </IonApp>
);

export default App;
