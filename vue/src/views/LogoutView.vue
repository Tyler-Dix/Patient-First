<template>
  <body>
  <h1>Logout</h1>
</body>
</template>

<script>

export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>

<style scoped >
@import '../css/styles.css';
</style>
