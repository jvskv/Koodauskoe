import { Button, Grid, TextField } from "@mui/material";
import React, { useState } from "react";

const HenkiloLomake = ({ submitHenkilo }) => {
    const [etunimi, setEtunimi] = useState('');
    const [sukunimi, setSukunimi] = useState('');
    const [syntymaaika, setSyntymaaika] = useState('');
    const [hetu, setHetu] = useState('');
    const [katuosoite, setKatuosoite] = useState('');
    const [postinumero, setPostinumero] = useState('');
    const [kaupunki, setKaupunki] = useState('');
    const [email, setEmail] = useState('');
    const [puhnmr, setPuhnmr] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();

    const henkilo = {
        etunimi,
        sukunimi,
        syntymaaika,
        hetu,
        katuosoite,
        postinumero,
        kaupunki,
        email,
        puhnmr
    };


    submitHenkilo(henkilo);

    setEtunimi('');
    setSukunimi('');
    setSyntymaaika('');
    setHetu('');
    setKatuosoite('');
    setPostinumero('');
    setKaupunki('');
    setEmail('');
    setPuhnmr('');

}

  return (
    <form onSubmit={handleSubmit}>
        <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                label="Etunimi"
                variant="outlined"
                fullWidth
                value={etunimi}
                onChange={(e) => setEtunimi(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                label="Sukunimi"
                variant="outlined"
                fullWidth
                value={sukunimi}
                onChange={(e) => setSukunimi(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                label="Syntymäaika"
                variant="outlined"
                fullWidth
                value={syntymaaika}
                onChange={(e) => setSyntymaaika(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                label="Hetu"
                variant="outlined"
                fullWidth
                value={hetu}
                onChange={(e) => setHetu(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                label="Katuosoite"
                variant="outlined"
                fullWidth
                value={katuosoite}
                onChange={(e) => setKatuosoite(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                type="number"
                label="Postinumero"
                variant="outlined"
                fullWidth
                value={postinumero}
                onChange={(e) => setPostinumero(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                label="Kaupunki"
                variant="outlined"
                fullWidth
                value={kaupunki}
                onChange={(e) => setKaupunki(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                required
                label="Email"
                variant="outlined"
                fullWidth
                value={email}
                onChange={(e) => setEmail(e.target.value)}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <TextField
                type="number"
                required
                label="Puhelinnumero"
                variant="outlined"
                fullWidth
                value={puhnmr}
                onChange={(e) => setPuhnmr(e.target.value)}/>
            </Grid>
            <Grid item xs={12}>
                <Button type="submit" variant="contained" color="primary">
                    Tallenna
                </Button>
            </Grid>
        </Grid>
    </form>
  )
};

  export default HenkiloLomake;