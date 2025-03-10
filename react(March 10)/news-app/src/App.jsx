import React, { useState, useEffect } from 'react';
import LoginForm from './components/LoginForm';
import NewsDashboard from './components/NewsDashboard';

const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [news, setNews] = useState([
    {
      title: 'Breaking News: React 19 Released!',
      description: 'React 19 introduces groundbreaking new features for developers.',
      content: 'React 19 has officially been released, bringing with it a host of new features such as automatic batching, improved server-side rendering, and a new JSX transform. Developers are excited about the performance improvements and streamlined development process.',
    },
    {
      title: 'Global Tech Conference 2023',
      description: 'The biggest tech conference of the year kicks off in San Francisco.',
      content: 'The Global Tech Conference 2023 is underway, featuring keynote speeches from industry leaders, hands-on workshops, and cutting-edge technology demonstrations. Attendees can expect to learn about the latest trends in AI, blockchain, and quantum computing.',
    },
    {
      title: 'New Study: Benefits of Remote Work',
      description: 'A recent study highlights the positive impact of remote work on productivity.',
      content: 'A new study published in the Journal of Workplace Innovation reveals that remote work can increase productivity by up to 20%. The study also found that employees reported higher job satisfaction and better work-life balance.',
    },
    {
      title: 'Apple Unveils New iPhone 15',
      description: 'Apple announces the latest iPhone with advanced features.',
      content: 'Apple has unveiled the iPhone 15, featuring a new titanium design, improved camera system, and faster A17 chip. The phone also supports USB-C charging, a first for iPhones.',
    },
    {
      title: 'SpaceX Launches Starship to Mars',
      description: 'SpaceX successfully launches its Starship rocket for a Mars mission.',
      content: 'SpaceX has successfully launched its Starship rocket, marking a significant step towards its goal of colonizing Mars. The mission aims to test the rocket’s capabilities for future manned missions.',
    },
    {
      title: 'Tesla Releases Full Self-Driving Beta',
      description: 'Tesla rolls out its Full Self-Driving Beta to all customers.',
      content: 'Tesla has released its Full Self-Driving Beta software to all customers in the US. The update includes improved navigation, autopilot, and safety features.',
    },
    {
      title: 'Microsoft Acquires Activision Blizzard',
      description: 'Microsoft completes its acquisition of Activision Blizzard.',
      content: 'Microsoft has finalized its acquisition of Activision Blizzard for $68.7 billion. The deal is expected to reshape the gaming industry and expand Microsoft’s presence in the market.',
    },
    {
      title: 'Google Announces New AI Features',
      description: 'Google introduces new AI-powered tools for its products.',
      content: 'Google has announced new AI features for its search engine, Gmail, and Google Docs. The updates include improved language models and enhanced productivity tools.',
    },
    {
      title: 'Amazon Launches New Echo Devices',
      description: 'Amazon unveils its latest lineup of Echo smart speakers.',
      content: 'Amazon has launched new Echo devices, including the Echo Show 15 and Echo Dot with Clock. The devices feature improved sound quality and new smart home integrations.',
    },
    {
      title: 'Netflix Introduces Ad-Supported Plan',
      description: 'Netflix launches a cheaper, ad-supported subscription plan.',
      content: 'Netflix has introduced a new ad-supported subscription plan, offering lower prices for users willing to watch ads. The plan is available in select countries.',
    },
  ]);

  const handleLogin = (username, password) => {
    if (username === 'admin' && password === 'password') {
      setIsLoggedIn(true);
    } else {
      alert('Invalid credentials');
    }
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  const addNews = (newArticle) => {
    setNews([...news, newArticle]);
  };

  const removeNews = (index) => {
    const updatedNews = news.filter((_, i) => i !== index);
    setNews(updatedNews);
  };

  return (
    <div className="container mt-5">
      {!isLoggedIn ? (
        <LoginForm onLogin={handleLogin} />
      ) : (
        <NewsDashboard news={news} addNews={addNews} removeNews={removeNews} onLogout={handleLogout} />
      )}
    </div>
  );
};

export default App;