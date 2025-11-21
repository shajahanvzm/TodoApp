const User = (user) => {
  const { name, age, location } = user.user;
  return (
    <div>
      <h2>User Information</h2>
      <p>Name: {user.user.name}</p>
      <p>Age: {user.user.age}</p>
      <p>Location: {user.user.location}</p>

      <hr />
      <p>Name : {name}</p>
      <p>Age: {age}</p>
      <p>Location: {location}</p>
    </div>
  );
};

export default User;
