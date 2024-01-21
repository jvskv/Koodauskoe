import React, { useState, useEffect } from "react";
import {
  Container,
  Typography,
  List,
  ListItem,
  ListItemText,
} from "@mui/material";
import HenkiloLomake from "./components/HenkiloLomake";

function App() {
  const [henkilot, setHenkilot] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/henkilot")
      .then((response) => response.json())
      .then((data) => setHenkilot(data))
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const handleHenkiloSubmit = (henkilo) => {
    fetch("http://localhost:8080/api/henkilot", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(henkilo),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to save data");
        }
        return fetch("http://localhost:8080/api/henkilot");
      })
      .then((response) => response.json())
      .then((data) => setHenkilot(data))
      .catch((error) => console.error("Error saving data:", error));
  };

  return (
    <Container>
      <Typography variant="h4" gutterBottom>
        Henkilön tiedot
      </Typography>
      <HenkiloLomake submitHenkilo={handleHenkiloSubmit} />
      <Typography variant="h5" gutterBottom style={{ marginTop: "20px" }}>
        Lisätyt henkilöt
      </Typography>
      <List>
        {henkilot.map((henkilo) => (
          <ListItem key={henkilo.id}>
          <ListItemText
            primary={
              `${henkilo.etunimi} ${henkilo.sukunimi} ${henkilo.syntymaaika} ${henkilo.hetu ? henkilo.hetu.hetu : ''}`
              + ` ${henkilo.osoite ? henkilo.osoite.osoite : ''} ${henkilo.yhteystiedot ? henkilo.yhteystiedot.email : ''}`
              + ` ${henkilo.yhteystiedot ? henkilo.yhteystiedot.puhnmr : ''}`
            }
          />
        </ListItem>
        ))}
      </List>
    </Container>
  );
}

export default App;
